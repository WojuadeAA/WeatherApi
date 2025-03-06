FROM ubuntu:latest
LABEL authors="wojuade"

ENTRYPOINT ["top", "-b"]