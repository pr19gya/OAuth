import React, { useEffect, useState } from "react";
import { SERVER_URL } from "../constant/Baseurl";
import axios from "axios";
import Logout from "./Logout";

const MainPage = () => {
  const [info, setInfo] = useState([]);

  const getInfo = async () => {
    let data = JSON.stringify({
      query: `query{
        allLanguages{
            languageId,
            language,
            codeSyntax
        }
    }`,
      variables: {}
    });
    
    let config = {
      method: 'post',
      maxBodyLength: Infinity,
      url: SERVER_URL+'/graphql',
      withCredentials: true, 
      headers: { 
        'Content-Type': 'application/json'
      },
      data: data
    };
    
    try {
      const response = await axios.request(config);
      setInfo(response.data.data.allLanguages); 
    } catch (error) {
      console.log(error);
    }
    
    
  }

  const handleLogout = () => {
    Logout(); // Call the logout function
  };

  useEffect(() => {
    getInfo();
  }, []);

  return (
    <>
      
      <h1>Programming Languages</h1>
      {info.length > 0 && (
        <table>
          <thead>
            <tr>
              <th>Language ID</th>
              <th>Language</th>
              <th>Code Syntax</th>
            </tr>
          </thead>
          <tbody>
            {info.map((item) => (
              <tr key={item.languageId}>
                <td>{item.languageId}</td>
                <td>{item.language}</td>
                <td>{item.codeSyntax || "N/A"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      <button onClick={handleLogout}>Logout</button>
    </>
  );
}

export default MainPage;
