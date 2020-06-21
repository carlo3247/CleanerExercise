# Problem
This repository is an implementation of the [java exercise from marshmallow](https://github.com/marshmallow-insurance/java-backend-test).

# Solution
The code for the solution can be accessed under `exercise/src/main/java/com/example/exercise`. The entry point for the web server is the `Application.java` file. To solve the task a `Navigator.java` object is created, which navigates an `Area.java`.

# Installation/Run
To run the project navigate into the `exercise` folder. Then, the development server can be started with the command shown below. The server is listening to port `8080`.
```bash
cd exercise
./mvnw spring-boot:run
```

# Example
With the server up and running a JSON payload can be sent to the server.
```JSON
{
  "areaSize" : [5, 5],
  "startingPosition" : [1, 2],
  "oilPatches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "navigationInstructions" : "NNESEESWNWW"
}
```

The server will attempt to run the posted problem and respond with the final position and the number of oil patches cleaned.
```JSON
{
  "finalPosition" : [1, 3],
  "oilPatchesCleaned" : 1
}
```