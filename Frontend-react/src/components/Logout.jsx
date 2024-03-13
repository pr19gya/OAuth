const Logout = () => {
    // Clear any authentication-related data
    // For example, you might want to clear localStorage or sessionStorage
    localStorage.removeItem("token");
  
    // Redirect to the login page
    window.location = "http://localhost:8080/login";
  };
  
  export default Logout;
  