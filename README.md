# PUT-SE-BuildingInfo

Release: 

![GitHub release (latest by date)](https://img.shields.io/github/v/release/lukik45/PUT-SE-BuildingInfo?display_name=tag&style=plastic)

Automatic build and tests status:

![abts-workflow](https://github.com/lukik45/PUT-SE-BuildingInfo/actions/workflows/ci.yml/badge.svg)

Automatic distribution package creation:

![package-dist](https://github.com/lukik45/PUT-SE-BuildingInfo/actions/workflows/package-distribution.yml/badge.svg)

> Package created as an artifact in Github Actions [process](https://github.com/lukik45/PUT-SE-BuildingInfo/actions/workflows/package-distribution.yml)

## Product Description
For building administrators who want to minimise the costs of building management, our Building Info application will enable obtaining information about building parameters at the level of rooms, floors and entire buildings. The application will be available via GUI and also as a remote API, thanks to which it can be integrated with existing tools. 

### Data Structure
- A location is a building, level, or room
- The building may consist of levels and those of rooms
- Each location is characterized by:
  -  id – unique identifier
  - name – optional name of the location
- The room is additionally characterised by:
  - area = area in m^2
  - cube = room volume in m^3
  - heating = level of heating energy consumption (float)
  - light – total lighting power


## API usage

### POST the structure of the building
Path: `localhost:localhost:8080/api/v1/building`

Body: JSON file representing the structure of the building, as in example:
```json
{
  "name": "exemplary building",
  "id": "2",
  "children": [
    {
      "name": "First floor",
      "id": "21",
      "children": [
        {
          "name": "First room",
          "id": "221",
          "area": "30.0",
          "cube": "75.0",
          "heating": "1550.95",
          "light": "2000.0"
        }
      ]
    }
  ]
}
```

### GET the parameters
`id`: the id of the component provided in JSON file
- Check the area of a component (building/floor/room)
  - Path:  `localhost:localhost:8080/api/v1/building/area/{id}`

- Check the volume of a component (building/floor/room)

  - Path:  `localhost:localhost:8080/api/v1/building/volume/{id}`

- Calculate the lightning power per unit of volume of a component (building/floor/room)
  - Path:  `localhost:localhost:8080/api/v1/building/heating/{id}`

- Calculate the heating energy consumption per unit of area of a component (building/floor/room)
  - Path:  `localhost:localhost:8080/api/v1/building/heating/{id}`

### GET the information about rooms that exceed the maximal level of heat consumption/m^3
`threshold`: the maximal value that is allowed

path: `localhost:8080/api/v1/building/heating-report/{threshold}`
