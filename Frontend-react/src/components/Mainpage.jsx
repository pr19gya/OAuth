import React, { useEffect, useState } from "react";
import { SERVER_URL } from "../constant/Baseurl";

function MainPage() {
    const [info, setInfo] = useState([]);


  const getInfo = async () => {
    console.log(SERVER_URL);
    const response = await fetch(SERVER_URL + "/graphql", {
      method: "POST",
      redirect: "follow",
      credentials:"include"
    }).then((response) => response);
    console.log(response);
    if (response.redirected) {
      document.location = response.url;
    }

    const data = await response.json();
    setInfo(data);
    console.log(data);
  };

  useEffect(() => {
    getInfo();
  }, []);

  return (
    <>
    hello
        {info && (
            <table>
                <tbody>
                    {info.map((item) => (
                        <tr key={item.languageId}>
                            <td>{item.language}</td>   
                        </tr>
                    ))}
                </tbody>
            </table>
        )}
    </>
);

}

export default MainPage;
