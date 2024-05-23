#!/usr/bin/env sh

set -e

date
echo "Waiting for database kitchendb to be available"

while ! nc -z kitchendb 3306; do sleep 5; done;

echo starting application
catalina.sh run
