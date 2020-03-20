#!/usr/bin/env bash
kubectl create -f deployment kubernates/people-service-configmap.yaml
kubectl create -f deployment kubernates/people-service-deployment.yaml
