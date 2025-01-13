# ZipCode Lookup Service

This is a Spring Boot application that allows users to retrieve the place name for a given postal code (ZIP Code) in the United States by querying the Zippopotam API.

## Features

- Accepts a ZIP code as a path variable.
- Fetches the corresponding place name (city) from the Zippopotam API.
- Returns the place name in the response.
- Handles different zip codes and provides a corresponding city or place name.

## Technology Stack

- **Spring Boot** - The main framework for building the REST API.
- **RestTemplate** - For making HTTP requests to the Zippopotam API.
- **Lombok** - To reduce boilerplate code (getters, setters, constructors).
- **Jackson** - For JSON processing and deserialization.

## Setup and Installation

### 1. Clone the Repository

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/yourusername/zipcode-lookup-service.git
```

### 2. Install Dependencies

Ensure you have Java 11+ and Maven installed. You can download them from [OpenJDK](https://openjdk.java.net/) and [Maven](https://maven.apache.org/).

Then navigate to the project folder and run:

```bash
mvn install
```

This will download all necessary dependencies.

### 3. Running the Application

To start the application, run the following command in your terminal:

```bash
mvn spring-boot:run
```

The Spring Boot application will start on `http://localhost:8080`.

## API Endpoint

The main endpoint for the service is:

```
GET /zipcode/{postalCode}
```

### Example Request:

```bash
GET http://localhost:8080/zipcode/90210
```

### Example Response:

For the above request, the response will look like:

```json
"Beverly Hills"
```

### Other Example Zip Codes:

Here are a few example zip codes you can use for testing:

- `90210` - Beverly Hills, California
- `10001` - New York, New York
- `30301` - Atlanta, Georgia
- `94103` - San Francisco, California
- `20001` - Washington, D.C.
- `33163` - Miami, Florida
- `75201` - Dallas, Texas
- `77001` - Houston, Texas
- `90291` - Venice, California
- `44114` - Cleveland, Ohio

### Error Handling:

If a postal code is invalid or no data is found for the given postal code, the API will return a message like:

```json
"Error: No places found for the postal code: 00000"
```

## Project Structure

```
zipcode-lookup-service/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tcs/
│   │   │           └── zipcodes/
│   │   │               ├── ZipCodeController.java
│   │   │               ├── ZipCodeService.java
│   │   │               └── ZippopotamResponse.java
│   │   └── resources/
│   │       ├── application.properties
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── tcs/
│       │           └── zipcodes/
│       │               └── ZipCodeServiceTests.java
├── pom.xml
└── README.md
```

### Key Classes:

1. **`ZipCodeController.java`**: This class defines the REST API endpoint and handles the HTTP requests for postal codes.
2. **`ZipCodeService.java`**: This class is responsible for making the external API request to Zippopotam and processing the response.
3. **`ZippopotamResponse.java`**: This class defines the structure of the response returned from the Zippopotam API and maps it to the Java objects.
4. **`application.properties`**: Configuration file for the application.

## Dependencies

The project uses the following dependencies:

- **Spring Boot**: For building the REST API.
- **RestTemplate**: For making HTTP requests.
- **Lombok**: For reducing boilerplate code.
- **Jackson**: For JSON parsing and mapping.
  
Dependencies are managed via Maven in the `pom.xml`.

## Troubleshooting

- Ensure the Zippopotam API is online and functional. If it's down, the application might not work as expected.
- If you encounter any issues, check the console logs for more information or raise an issue on GitHub.

## Contributing

Contributions are welcome! If you find a bug or have an idea for a new feature, feel free to open an issue or submit a pull request.
