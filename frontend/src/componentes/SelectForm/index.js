import React from 'react';

import './styles.css'

function SelectForm(props) {

    return (
       <div className="select-form">
            <label htmlFor="cadastrar">Cadastrar</label>
            <input type="radio" id="cadastrar" name="selectForm" value="cadastrar" />

            <label htmlFor="buscar">Buscar</label>
            <input type="radio" id="buscar" name="selectForm" value="buscar" />
        </div>
    )

}

export default SelectForm;