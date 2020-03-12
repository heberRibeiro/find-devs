import React from 'react';

function DevBuscar(props) {

    return (
        <React.Fragment>
            <strong>Buscar</strong>
            <form>

                <label htmlFor="techs">Tecnologias</label>
                <input type="text" id="techs" name="techs" />

                <label htmlFor="raio">Raio(m)</label>
                <input type="number" id="raio" name="raio" />

                <div className="coordinates">
                    <div className="longitude">
                        <label htmlFor="longitude">Longitude</label>
                        <input
                            type="number"
                            name="longitude"
                            id="longitude"
                        />
                    </div>
                    <div className="latitude">
                        <label htmlFor="latitude">Latitude</label>
                        <input
                            type="number"
                            name="latitude"
                            id="latitude"
                        />
                    </div>
                </div>
                <button type="submit">Buscar</button>

            </form>
        </React.Fragment>
    )
}

export default DevBuscar;