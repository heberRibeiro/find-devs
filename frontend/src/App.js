import React from 'react';

import './Global.css'
import './App.css'

function App() {
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
              <input name="longitude" id="longitude" />
            </div>
            <div className="latitude">
              <label htmlFor="latitude">Latitude</label>
              <input name="latitude" id="latitude" />
            </div>
          </div>
          <button type="submit">Salvar</button>
        </form>
      </aside>
      <main>

      </main>
    </div>
  );
}

export default App;
