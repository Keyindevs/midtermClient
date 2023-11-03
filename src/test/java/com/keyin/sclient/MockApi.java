package com.keyin.sclient;

public class MockApi {


    public MockApi() {
    /**
     *
     **/
    }

    public String getCity() {
        String city = """
                {
                    "id": 1,
                    "name": "New York",
                    "state": "NY",
                    "population": 8623000,
                    "airports": [
                        {
                            "name": "John F. Kennedy International Airport",
                            "code": "JFK",
                            "city": "New York",
                            "onPremisePlanes": [
                                {
                                    "id": "WS5R5",
                                    "type": "Airbus A380",
                                    "airlineName": "Emirates",
                                    "numberOfPassengers": 853,
                                    "airport": "JFK",
                                    "boardedPassengers": []
                                }
                            ],
                            "onPremisePassengers": [],
                            "flightsIn": [
                                {
                                    "id": "00001",
                                    "origin": "YYT",
                                    "destination": "JFK",
                                    "aircraft": "A17V5"
                                }
                            ],
                            "flightsOut": []
                        },
                        {
                            "name": "Alex's Airport",
                            "code": "AAP",
                            "city": "New York",
                            "onPremisePlanes": [],
                            "onPremisePassengers": [],
                            "flightsIn": [],
                            "flightsOut": []
                        }
                    ],
                    "habitants": [
                        {
                            "firstName": "Jimmy",
                            "lastName": "Dingle",
                            "homeTown": "New York",
                            "flights": null
                        }
                    ]
                },
                """;
        return city;
    }

    public String getAircraft() {
        String aircraft = """
                {
                    "type": "Airbus A380",
                    "airlineName": "Emirates",
                    "numberOfPassengers": 853,
                    "airport": "JFK",
                    "id": "WS5R5"
                }
                """;
        return aircraft;
    }

    public String getAirport() {
        String airport = """
                {
                    "name": "John F. Kennedy International Airport",
                    "code": "JFK",
                    "city": "New York",
                    "onPremisePlanes": [
                        {
                            "id": "WS5R5",
                            "type": "Airbus A380",
                            "airlineName": "Emirates",
                            "numberOfPassengers": 853,
                            "airport": "JFK",
                            "boardedPassengers": []
                        }
                    ],
                    "onPremisePassengers": [],
                    "flightsIn": [
                        {
                            "id": "00001",
                            "origin": "YYT",
                            "destination": "JFK",
                            "aircraft": "A17V5"
                        }
                    ],
                    "flightsOut": []
                }
                """;
        return airport;
    }

    public String getFlights() {
        String flight = """
                {
                    "id": "00001",
                    "origin": "YYT",
                    "destination": "JFK",
                    "aircraft": "A17V5"
                }
                """;
        return flight;
    }

    public String getPassenger() {
        String passenger = """
                {
                    "firstName": "Jimmy",
                    "lastName": "Dingle",
                    "homeTown": "New York",
                    "flights": null
                }
                """;
        return passenger;
    }

}
