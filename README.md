In this we try to consume the FakeStore - https://fakestoreapi.com/docs api

**Flow**
**normal flow for db**
    
    controller --> service --> repository --> db

**Flow for 3rd party api**

    controller --> service --> client --> 3rd Party api

**DTO flow**

    API -> Controller -> service --> mapper --> API Client --> 3rd party api

**Mapper is used to convert**

    ProductRequestDTO to FakeStoreProductRequestDTO
    FakeStoreProductResponseDTO to ProductResponseDTO

Folder Description

    controller -  contain all the classes for req mapping
    service -  contain business logic
    mapper - used to convert ProductRequestDTO to FakeStoreProductRequestDTO and FakeStoreProductResponseDTO to ProductResponseDTO
    client - used to interact with 3rd party api
    model -  simple pojo classes
    exception - used to create custom exception
    dto - use to create req/res object
    util - used to create other utility classes

application.properties - anything we want to provide from outside

    #FakeStore Config
    fakestore.api.url = https://fakestoreapi.com
    fakestore.api.path.product = /products
    fakestore.api.path.category = /category
