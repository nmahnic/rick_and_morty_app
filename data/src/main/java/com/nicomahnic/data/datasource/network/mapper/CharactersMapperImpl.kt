package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import com.nicomahnic.data.datasource.network.model.LocationNetworkEntity
import com.nicomahnic.data.datasource.network.model.OriginNetworkEntity
import com.nicomahnic.data.datasource.network.model.CharacterNetworkEntityResponse
import com.nicomahnic.domain.model.LocationModel
import com.nicomahnic.domain.model.OriginModel
import com.nicomahnic.domain.model.CharacterModel

class CharactersMapperImpl : CharactersMapper {

    override fun toModel(entity: CharacterNetworkEntityResponse) = CharacterModel(
        created = entity.created,
        episode = entity.episode,
        gender = entity.gender,
        id = entity.id,
        image = entity.image,
        location = toModel(entity.location),
        name = entity.name,
        origin = toModel(entity.origin),
        species = entity.species,
        status = entity.status,
        type = entity.type,
        url = entity.url
    )

    override fun toListModel(entity: CharactersNetworkEntityResponse): List<CharacterModel> {
        return entity.results.map { this.toModel(it) }
    }
    
    private fun toModel(entity: LocationNetworkEntity) = LocationModel(
        name = entity.name,
        url = entity.url
    )

    private fun toModel(entity: OriginNetworkEntity) = OriginModel(
        name = entity.name,
        url = entity.url
    )
    
}