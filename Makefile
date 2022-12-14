# Docker config.
DOCKER_PATH=./docker/docker-compose.yml
DB_NAME=postgres

# Colors
RED     := $(shell tput -Txterm setaf 1)
GREEN   := $(shell tput -Txterm setaf 2)
BLUE    := $(shell tput -Txterm setaf 4)
CYAN    := $(shell tput -Txterm setaf 6)
RESET   := $(shell tput -Txterm sgr0)

## Docker

dk-status: ## Check the docker container status.
	@docker ps --filter "name=mysql-8.0"

dk-run: ## Build & Run the local docker.
	@docker compose -f ${DOCKER_PATH} build ${DB_NAME}
	@docker compose -f ${DOCKER_PATH} up  ${DB_NAME}

dk-start: ## Start the local docker.
	@docker compose -f ${DOCKER_PATH} start ${DB_NAME}
	@sleep 2

dk-stop: ## Stop the local docker.
	@docker compose -f ${DOCKER_PATH} stop ${DB_NAME}

dk-reset: ## Stop, Delete, Build and Start the local docker.
	@docker compose -f ${DOCKER_PATH} stop ${DB_NAME}
	@docker compose -f ${DOCKER_PATH} down --volumes
	@docker compose -f ${DOCKER_PATH} rm ${DB_NAME}
	@docker compose -f ${DOCKER_PATH} build ${DB_NAME}
	@docker compose -f ${DOCKER_PATH} up ${DB_NAME}

dk-prune: ## Delete all docker volumes.
	@docker compose -f ${DOCKER_PATH} rm ${DB_NAME}
	@cd ./docker
	@docker volume prune
	@cd ..

## Help
# https://gist.github.com/thomaspoignant/5b72d579bd5f311904d973652180c705
help: ## Show this help.
	@echo ''
	@echo 'Usage:'
	@echo '  ${CYAN}make${RESET} ${GREEN}<target>${RESET}'
	@echo ''
	@echo 'Targets:'
	@awk 'BEGIN {FS = ":.*?## "} { \
		if (/^[a-zA-Z_-]+:.*?##.*$$/) {printf "    ${CYAN}%-20s${GREEN}%s${RESET}\n", $$1, $$2} \
		else if (/^## .*$$/) {printf "  ${BLUE}%s${RESET}\n", substr($$1,4)} \
		}' $(MAKEFILE_LIST)