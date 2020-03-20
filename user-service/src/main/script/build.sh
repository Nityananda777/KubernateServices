#!/usr/bin/env bash
kubectl create -f deployment user_service-configmap.yaml
kubectl create -f deployment user_service-deployment.yaml
