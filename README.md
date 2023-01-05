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

React JS using TypeScript and Sass in an S3 bucket.

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

## Manual Deployment Using Serverless

If any changes are made to the project make sure to build the application with all dependencies using:

```
gradle packageFat
```

#### Install serverless

```
npm install -g serverless
```

##### Deploy frontend

Run command inside the `infra\frontend` folder

```
npm install
serverless client deploy --no-confirm
```

##### Deploy backend

Run command inside the `infra\backend` folder

```
npm install
serverless  deploy --param="username=<db_user>" --param="password=<db_password>"
```

More information on this link:
https://www.serverless.com/plugins/serverless-finch#command-line-parameters


## Using front-end locally

#### Node JS

Ensure you have Node and npm installed locally.

node version: `16.14.0`,
npm version: `8.19.3`


#### Local environment variable setup

You will need to create a `.env` file in the root of the `frontend` folder of this project. This needs to contain a variable for the base HTTP route of the back-end in the following format:
```
REACT_APP_BACKEND_URL=<back_end_base_url>
```

In the `frontend` directory, you can run:

##### To install dependences
```
npm install
```
##### Runs the app in the development mode
```
npm run start
```

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

## Tests

### Front-end

Run these commands inside the `frontend` directory.

To Launch all the test runner in the interactive watch mode:
```
npm run test
```

See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

To Lanch a specific test runner:
```
npm run test [test name]
```

### Back-end

Run this commands inside the `backend` directory.

Make sure Gradle is installed locally and run:
```
gradle test
```
