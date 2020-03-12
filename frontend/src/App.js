import React, { useState, useEffect } from 'react';
import api from './service/api'

import './Global.css'
import './App.css'
import './Aside.css'
import './Main.css'

import DevItem from './componentes/DevItem'
import DevForm from './componentes/DevForm'
import DevBuscar from './componentes/DevBuscar'
import SelectForm from './componentes/SelectForm'

function App() {
  const [devs, setDevs] = useState([])

  useEffect(() => {
    async function loadDevs() {
      const response = await api.get('/devs')
      setDevs(response.data)
    }

    loadDevs()
  }, [])

  async function handleSubmit(data) {
    /* Solution using axios */
    const response = await api.post('/devs', data)

    setDevs([...devs, response.data]) // Create a new dev's array with a new post dev

  }

  return (
    <div id="app">
      <aside>
        <DevForm onSubmit={handleSubmit} />
        {/* <DevBuscar/> */}
        <SelectForm/>
      </aside>
      <main>
        <ul>
          {devs.map(dev => (
            <DevItem key={dev.id} dev={dev} />
          ))}
        </ul>
      </main>
    </div>
  );
}

export default App;