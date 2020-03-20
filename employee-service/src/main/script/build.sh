#!/usr/bin/env bash
kubectl create -f deployment employee_service-configmap.yaml
kubectl create -f deployment employee_service-deployment.yaml
