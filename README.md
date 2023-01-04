# CoduraWise
***The Codurance curated resource sharing platform***

## About this Application

#### What's the problem we're solving?

Crafts People want to find great resources on specific subjects, saving them time and effort sifting through poor quality and exhaustive amounts of resources.

This application is designed for Crafts People to post resources, submit ratings and reviews on those resources.

Resources can be categorised and filtered for easy searching.

## Technology Stack

The app is constructed as a distributed system with a separate front-end and back-end. There are distributed using AWS services using serverless and GitHub Actions for CI/CD pipelines.

#### Front-end

React Native Library using TypeScript and Sass in an S3 bucket.

#### Back-end

Gateways and Lambdas are used with Java using a RDS MySQL database service.

#### CI/CD pipelines

There are two separate pipelines, for front-end and back-end.
These are coded for GitHub Actions using Serverless to deploy the AWS services.

#### Overview of structure

![image of technology_stack](readme_images/technology_stack.png)

#### C4 Diagrams

![C1 and C2 Diagrams](readme_images/c1_c2_diagrams.png)
![C3 Diagrams](readme_images/c3_diagram.png)

## Running front-end locally

#### Node JS

Ensure you have Node and npm installed locally.

node version: `16.14.0`,
npm version: `8.19.3`


#### Local environment variable setup

You will need to create a `.env` file in the root of the `frontend` folder of this project. This needs to contain a variable for the base HTTP route of the back-end in the following format:
```
REACT_APP_BACKEND_URL=<base_HTTP_route>
```

#### Run front-end

Within the `frontend` folder in the terminal window.
First insure you have the dependencies installed with:
```
npm install
```
Then:
```
npm run start
```

#### Running tests
```
npm run tests
```
