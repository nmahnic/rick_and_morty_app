package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import com.nicomahnic.data.datasource.network.model.InfoNetworkEntity
import com.nicomahnic.data.datasource.network.model.LocationNetworkEntity
import com.nicomahnic.data.datasource.network.model.OriginNetworkEntity
import com.nicomahnic.data.datasource.network.model.ResultNetworkEntity
import com.nicomahnic.domain.model.Characters
import com.nicomahnic.domain.model.InfoNetwork
import com.nicomahnic.domain.model.Location
import com.nicomahnic.domain.model.Origin
import com.nicomahnic.domain.model.Result

class CharactersMapperImpl : CharactersMapper {
    override fun toModel(entity: CharactersNetworkEntityResponse) = Characters(
        info = toModel(entity.info),
        results = entity.results.map { toModel(it) }
    )
    
    private fun toModel(entity: InfoNetworkEntity) = InfoNetwork(
        count = entity.count,
        next = entity.next,
        pages = entity.pages,
        prev = entity.prev
    )
    
    private fun toModel(entity: ResultNetworkEntity) = Result(
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
    
    private fun toModel(entity: LocationNetworkEntity) = Location(
        name = entity.name,
        url = entity.url
    )

    private fun toModel(entity: OriginNetworkEntity) = Origin(
        name = entity.name,
        url = entity.url
    )
    
}