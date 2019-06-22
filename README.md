# Steps To Build, Run, Test

## Install Docker and Docker Compose via docker official website
None of the below will work until you complete this step. 

## Grab config files for solr server

Run the following commands while inside git folder to place files in same directory as docker-compose file

This will take the default files from the docker image and place them in a local folder. (https://github.com/docker-solr/docker-solr-examples/tree/master/custom-configset)
### `docker create --rm --name copier solr`
### `docker cp copier:/opt/solr/server/solr/configsets/_default myconf`
### `docker rm copier`

Now you have the folder myconf locally

### Create the mycores folder <-- this folder will be empty for now but in the future will have contents

## Now you are ready to run the server and spring boot app.

### `docker-compose up -d` <-- -d places it in the background.
### if you place in background `docker-compose logs -f` will tail the logs 

## Now launch the application after the images download and the app starts

http://localhost:8983/solr/#/ <-- to see the solr UI
http://localhost:8984/employee/random <-- to generate a random amount of employees in the database. 
Generates [75000,17500) at a time
