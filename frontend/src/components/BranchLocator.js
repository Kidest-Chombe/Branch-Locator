import React, { useState, useEffect } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import L from "leaflet";
import "leaflet/dist/leaflet.css";
import { getAllBranches, getNearestBranch, getNearbyBranches } from "../services/api";

delete L.Icon.Default.prototype._getIconUrl;
L.Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png"),
});

const BranchLocator = () => {
  const [branches, setBranches] = useState([]);
  const [loading, setLoading] = useState(false);
  const [district, setDistrict] = useState("");

  useEffect(() => {
    fetchBranches();
  }, []);

  const fetchBranches = async () => {
    setLoading(true);
    try {
      const response = await getAllBranches();
      setBranches(response.data);
    } catch (error) {
      console.error("Error fetching branches:", error);
      setBranches([]);
    } finally {
      setLoading(false);
    }
  };

  const handleDistrictSearch = async () => {
    if (!district.trim()) return alert("Enter a district or city name");

    setLoading(true);
    try {
      const response = await getNearestBranch(district);
      setBranches(response.data);
    } catch (error) {
      console.error("Error fetching nearest branch:", error);
      alert("Error searching for branches. Please try again.");
      setBranches([]);
    } finally {
      setLoading(false);
    }
  };

  const handleLocationSearch = () => {
    if (!navigator.geolocation) return alert("Geolocation is not supported");

    setLoading(true);
    navigator.geolocation.getCurrentPosition(
      async ({ coords }) => {
        const { latitude, longitude } = coords;
        try {
          const response = await getNearbyBranches(latitude, longitude, 10);
          setBranches(response.data);
        } catch (error) {
          console.error("Error fetching nearby branches:", error);
          alert("Error finding nearby branches. Please try again.");
          setBranches([]);
        } finally {
          setLoading(false);
        }
      },
      (error) => {
        alert("Unable to retrieve your location: " + error.message);
        setLoading(false);
      }
    );
  };

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        height: "100vh",
        fontFamily: "'Arial', sans-serif"
      }}
    >
      <header
        style={{
          backgroundColor: "#00a651", 
          color: "white",
          padding: "15px 20px",
          display: "flex",
          alignItems: "center",
          justifyContent: "space-between",
          boxShadow: "0 2px 4px rgba(0,0,0,0.1)"
        }}
      >
        <div style={{ display: "flex", alignItems: "center" }}>
          <img 
            src="https://tse1.mm.bing.net/th/id/OIP.4IejVhnSMEcsFRO1N9vp9QHaHa?r=0&rs=1&pid=ImgDetMain&o=7&rm=3" 
            alt="DBE Logo" 
            style={{ 
              height: "50px", 
              marginRight: "15px",
              borderRadius: "5px"
            }}
          />
          <div>
            <h1 style={{ margin: 0, fontSize: "24px", fontWeight: "bold" }}>
              Development Bank of Ethiopia
            </h1>
            <p style={{ 
              margin: 0, 
              fontSize: "16px", 
              color: "#e5b833", 
              fontWeight: "bold",
              fontStyle: "italic"
            }}>
              Your Development Partner!
            </p>
          </div>
        </div>
        
      </header>

      <div
        style={{
          display: "flex",
          flexDirection: window.innerWidth <= 768 ? "column" : "row",
          flex: 1,
          overflow: "hidden"
        }}
      >
        <div
          style={{
            width: window.innerWidth <= 768 ? "100%" : "350px",
            padding: "20px",
            backgroundColor: "#f8f9fa",
            boxSizing: "border-box",
            overflowY: "auto",
            borderRight: "1px solid #e0e0e0"
          }}
        >
          <h3 style={{ color: "#00a651", marginTop: 0 }}>Branch Locator</h3>
          <p style={{ fontStyle: "italic", color: "#666", marginBottom: "20px" }}>
            Find the nearest DBE branch anywhere in Ethiopia
          </p>

          <div style={{ marginBottom: "20px" }}>
            <h4 style={{ color: "#00a651" }}>Find Nearest DBE Branch</h4>
            <input
              type="text"
              placeholder="Enter district or city"
              value={district}
              onChange={(e) => setDistrict(e.target.value)}
              onKeyPress={(e) => e.key === 'Enter' && handleDistrictSearch()}
              style={{ 
                padding: "10px", 
                width: "100%", 
                marginBottom: "10px", 
                borderRadius: "4px", 
                border: "1px solid #ccc",
                boxSizing: "border-box"
              }}
            />
            <button
              onClick={handleDistrictSearch}
              disabled={loading}
              style={{
                padding: "10px 16px",
                backgroundColor: "#00a651",
                color: "white",
                border: "none",
                width: "100%",
                marginBottom: "10px",
                borderRadius: "4px",
                cursor: loading ? "not-allowed" : "pointer",
                fontWeight: "bold"
              }}
            >
              {loading ? "Searching..." : "Search by District/City"}
            </button>
            <button
              onClick={handleLocationSearch}
              disabled={loading}
              style={{
                padding: "10px 16px",
                backgroundColor: "#4caf50",
                color: "white",
                border: "none",
                width: "100%",
                borderRadius: "4px",
                cursor: loading ? "not-allowed" : "pointer",
                fontWeight: "bold"
              }}
            >
              {loading ? "Locating..." : "Use My Location"}
            </button>
            <button
              onClick={fetchBranches}
              disabled={loading}
              style={{
                padding: "10px 16px",
                backgroundColor: "#666",
                color: "white",
                border: "none",
                width: "100%",
                marginTop: "10px",
                borderRadius: "4px",
                cursor: loading ? "not-allowed" : "pointer",
                fontWeight: "bold"
              }}
            >
              {loading ? "Loading..." : "Show All Branches"}
            </button>
          </div>

          <div>
            <h4 style={{ color: "#00a651" }}>Branches ({branches.length})</h4>
            {loading ? (
              <p>Loading branches...</p>
            ) : branches.length === 0 ? (
              <p>No branches found. Try a different search.</p>
            ) : (
              <ul style={{ listStyle: "none", padding: 0 }}>
                {branches.map((branch) => (
                  <li
                    key={branch.id}
                    style={{ 
                      padding: "15px", 
                      borderBottom: "1px solid #e0e0e0",
                      backgroundColor: "#fff",
                      marginBottom: "10px",
                      borderRadius: "4px",
                      boxShadow: "0 1px 3px rgba(0,0,0,0.1)"
                    }}
                  >
                    <strong style={{ color: "#00a651" }}>{branch.name}</strong>
                    <br />
                    <span style={{ fontSize: "14px" }}>
                      {branch.address}, {branch.city}
                      <br />
                      Phone: {branch.phone}
                      <br />
                      Services: {branch.services}
                    </span>
                  </li>
                ))}
              </ul>
            )}
          </div>
        </div>

        <div
          style={{
            flex: 1,
            height: window.innerWidth <= 768 ? "400px" : "100%",
          }}
        >
          <MapContainer
            center={[9.0227, 38.7469]} 
            zoom={6}
            style={{ height: "100%", width: "100%" }}
          >
            <TileLayer
              attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
              url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {branches.map((branch) => (
              <Marker
                key={branch.id}
                position={[branch.latitude, branch.longitude]}
              >
                <Popup>
                  <strong>{branch.name}</strong>
                  <br />
                  {branch.address}, {branch.city}
                  <br />
                  Phone: {branch.phone}
                  <br />
                  Services: {branch.services}
                </Popup>
              </Marker>
            ))}
          </MapContainer>
        </div>
      </div>

      <footer style={{
        backgroundColor: "#00a651",
        color: "white",
        textAlign: "center",
        padding: "15px",
        fontSize: "14px",
        display: "flex",
        flexDirection: "column",
        alignItems: "center"
      }}>
        <div style={{ display: "flex", alignItems: "center", marginBottom: "10px" }}>
          <span style={{ fontWeight: "bold" }}>Development Bank of Ethiopia</span>
        </div>
        <div>
          © {new Date().getFullYear()} Development Bank of Ethiopia. All rights reserved. | 
          <span style={{ color: "#e5b833", fontWeight: "bold", margin: "0 5px" }}>Your Development Partner!</span>
        </div>
      </footer>
    </div>
  );
};

export default BranchLocator;