#!/usr/bin/env bash
kubectl create -f deployment gateway-service-configmap.yaml
kubectl create -f deployment gateway-service-deployment.yaml
