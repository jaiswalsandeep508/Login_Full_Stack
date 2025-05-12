import React, { useState } from "react";
import axios from "axios";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async () => {
        try {
            console.log("Username before sending:", username); 
            console.log("Password before sending:", password);
            const response = await axios.post("http://localhost:8080/api/login", { 
                userName: username,
                password: password });
                console.log("Username before sending:", username); 
            alert(response.data);
        } catch (error) {
            alert("Login failed!");
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <input type="text" placeholder="Username" value = {username} onChange={(e) => setUsername(e.target.value)} />
            <input type="password" placeholder="Password" value = {password} onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
};

export default Login;
