import React, { useState, useEffect } from 'react'

function DevForm(props) {

    const { onSubmit } = props

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

    async function handleSubmit(e) {
        e.preventDefault()

        await onSubmit({
            github_username,
            techs,
            longitude,
            latitude
        })

        setTechs('')           // Clear the Techs from form in the end of call
        setGithubUsername('') // Clear the github_username from form in the end of call
    }

    return (
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
    )
}

export default DevForm