#!/usr/bin/env bash
kubectl create -f deployment kubernates/mongodb-secret.yaml
kubectl create -f deployment kubernates/mongodb-service-configmap.yaml
kubectl create -f deployment kubernates/mongodb-service-deployment.yaml
kubectl create -f deployment kubernates/mongodb-secret.yaml
kubectl create -f deployment kubernates/mysql-configmap.yaml
kubectl create -f deployment kubernates/mysql-deployment.yaml

kubectl create -f deployment kubernates/rabbitmq-secret.yaml
kubectl create -f deployment kubernates/rabbitmq-configmap.yaml
kubectl create -f deployment kubernates/rabbitmq-deployment.yaml

kubectl create -f deployment kubernates/discovery-service-configmap.yaml
kubectl create -f deployment kubernatediscovery-service-deployment.yaml

