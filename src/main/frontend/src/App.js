//import logo from './logo.svg';
//import './App.css';
//
//function App() {
//  return (
//    <div className="App">
//      <header className="App-header">
//        <img src={logo} className="App-logo" alt="logo" />
//        <p>
//          Edit <code>src/App.js</code> and save to reload.
//        </p>
//        <a
//          className="App-link"
//          href="https://reactjs.org"
//          target="_blank"
//          rel="noopener noreferrer"
//        >
//          Learn React
//        </a>
//      </header>
//    </div>
//  );
//}
//
//export default App;

import React, {useEffect, useState} from "react";
import axios from "axios";

function App()
{
    const [hello, setHello] = useState('');

    useEffect(() =>
    {
        axios.get('/api/hello').then(res => setHello(res.data)).catch(err => console.log(err));
    }, [])

    return (<div>From Backend : {hello}</div>)
}

export default App;