import React, { useState, useEffect } from 'react';
import api from './service/api'

import './Global.css'
import './App.css'
import './Aside.css'
import './Main.css'

function App() {
  const [devs, setDevs] = useState([])

  const [longitude, setLongitude] = useState('')
  const [latitude, setLatitude] = useState('')
  const [github_username, setGithubUsername] = useState('')
  const [techs, setTechs] = useState('')

  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const { longitude, latitude } = position.coords

        setLongitude(longitude)
        setLatitude(latitude)
      },
      (err) => {
        console.log(err)
      },
      {
        timeout: 30000,
      }
    );
  }, [])

  useEffect(() => {
    async function loadDevs() {
      const response = await api.get('/devs')
      setDevs(response.data)
    }
    
    loadDevs()
  }, [])

  async function handleSubmit(e) {
    e.preventDefault()
    /* Solution using axios */
    const response = await api.post('/devs', {
      github_username,
      techs,
      longitude,
      latitude
    })
    setTechs('')           // Clear the Techs from form in the end of call
    setGithubUsername('') // Clear the github_username from form in the end of call
    
   // return response

    /* Solution using fetch */
    // const url = "http://localhost:8080/devs"
    // const response = await fetch(url, {
    //   method: 'POST',
    //   mode: 'cors',
    //   headers: {
    //     'Accept': 'application/json',
    //     'Content-Type': 'application/json'
    //   },
    //   body: JSON.stringify({
    //     github_username,
    //     techs,
    //     longitude,
    //     latitude
    //   })
    // })
    // setTechs('')  // Clear the Techs from form in the end of fetch
    // setGithubUsername('') // Clear the github_username from form in the end of fetch
    // return response
  }

  return (
    <div id="app">
      <aside>
        <strong>Cadastrar</strong>
        <form onSubmit={handleSubmit}>

          <label htmlFor="github_username">Usuário do GitHub</label>
          <input
            name="github_username"
            id="github_username"
            value={github_username}
            onChange={e => setGithubUsername(e.target.value)}
          />

          <label htmlFor="techs">Tecnologias</label>
          <input
            name="techs"
            id="techs"
            value={techs}
            onChange={e => setTechs(e.target.value)}
          />

          <div className="coordinates">
            <div className="longitude">
              <label htmlFor="longitude">Longitude</label>
              <input
                type="number"
                name="longitude"
                id="longitude"
                value={longitude}
                onChange={e => setLongitude(e.target.value)}
              />
            </div>
            <div className="latitude">
              <label htmlFor="latitude">Latitude</label>
              <input
                type="number"
                name="latitude"
                id="latitude"
                value={latitude}
                onChange={e => setLatitude(e.target.value)}
              />
            </div>
          </div>
          <button type="submit">Salvar</button>
        </form>
      </aside>
      <main>
        <ul>
          <li className="dev-item">
            <header>
              <img src="https://avatars1.githubusercontent.com/u/55813932?s=460&v=4" alt="Heber Ribeiro" />
              <div className="dev-info">
                <strong>Heber Ribeiro</strong>
                <span>Java, JavaScript, Spring Boot, React</span>
              </div>
            </header>
            <p>Desenvolvedor em constante aprendizado</p>
            <a href="https://github.com/heberRibeiro/">Acessar perfil do GitHub</a>
          </li>
          <li className="dev-item">
            <header>
              <img src="https://avatars1.githubusercontent.com/u/55813932?s=460&v=4" alt="Heber Ribeiro" />
              <div className="dev-info">
                <strong>Heber Ribeiro</strong>
                <span>Java, JavaScript, Spring Boot, React</span>
              </div>
            </header>
            <p>Desenvolvedor em constante aprendizado</p>
            <a href="https://github.com/heberRibeiro/">Acessar perfil do GitHub</a>
          </li>
          <li className="dev-item">
            <header>
              <img src="https://avatars1.githubusercontent.com/u/55813932?s=460&v=4" alt="Heber Ribeiro" />
              <div className="dev-info">
                <strong>Heber Ribeiro</strong>
                <span>Java, JavaScript, Spring Boot, React</span>
              </div>
            </header>
            <p>Desenvolvedor em constante aprendizado</p>
            <a href="https://github.com/heberRibeiro/">Acessar perfil do GitHub</a>
          </li>
        </ul>
      </main>
    </div>
  );
}

export default App;