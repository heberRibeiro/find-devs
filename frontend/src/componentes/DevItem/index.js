import React from 'react'

import './styles.css'
import ButtonDelete from '../ButtonDelete'
import ButtonUpdate from '../ButtonUpdate'

function DevItem(props) {

    const { dev } = props

    return (
        <li className="dev-item">
            <header>
                <img src={dev.avatar_url} alt={dev.name} />
                <div className="dev-info">
                    <strong>{dev.name}</strong>
                    <span>{dev.techs.join(', ')}</span>
                </div>
            </header>
            <p>{dev.bio}</p>
            <a href={`https://github.com/${dev.github_username}`}>Acessar perfil do GitHub</a>
            <ButtonDelete />
            <ButtonUpdate />
        </li>
    )
}

export default DevItem