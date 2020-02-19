import React, { useState, useEffect } from 'react';

import './Global.css'
import './App.css'
import './Aside.css'
import './Main.css'

function App() {
  const [longitude, setLongitude] = useState('')
  const [latitude, setLatitude] = useState('')

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

  return (
    <div id="app">
      <aside>
        <strong>Cadastrar</strong>
        <form method="post">

          <label htmlFor="github_username">Usuário do GitHub</label>
          <input name="github_username" id="github_username" />

          <label htmlFor="techs">Tecnologias</label>
          <input name="techs" id="techs" />

          <label htmlFor="link">Link do GitHub</label>
          <input name="link" id="link" />

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
