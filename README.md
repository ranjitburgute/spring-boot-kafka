# spring-boot-kafka

## run kafka and zookeeper

docker-compose up -d

## stop kafka and zookeeper

docker-compose down

## start order service spring boot application


## start delivery service spring boot application


## send delivery request from postmon

header: POST

body: 
    {
    "id" : 1,
    "name": "Macbook",
    "price" : 999.00, 
    "quantity": 1
    }   

## verify logs for order and delivery service

## read messages from terminal

docker exec -it broker kafka-console-consumer \
                    --bootstrap-server broker:9092 \
                    --topic orders \
                    --from-beginning