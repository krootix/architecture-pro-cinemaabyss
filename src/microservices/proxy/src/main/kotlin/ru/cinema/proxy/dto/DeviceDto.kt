package ru.cinema.proxy.dto

data class DeviceDto (
    var id: Long,
    var houseId: Long,
    var userId: Long,
    var name: String,
    var serialNumber: String
)