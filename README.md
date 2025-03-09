# GitHub Repository Fetcher (Quarkus)
A simple Quarkus-based REST API that fetches public GitHub repositories for a given user.  
It filters out forked repositories and retrieves branch details along with the latest commit SHA.

## Requirements (versions used in project)
- Java 21
- Maven 3.13.0
- Quarkus 3.19.2

## How to Run the Application
1. Clone the repository:
```sh
    git clone https://github.com/kacpi-k/github-repository-fetcher.git
    cd github-repository-fetcher
```

2. Build the project:
```sh
  ./mvnw clean package
```
3. Run the application in development mode:
```sh
  ./mvnw quarkus:dev
```
4. The api will be available at:
```http
http://localhost:8080
```

## API Endpoints

### Get repositories for a GitHub user
```http
GET /github/{{username}}/repos
```
#### Example response for <http://localhost:8080/github/kacpi-k/repos>
```json
[
    {
        "repository_name": "BandUp-backend",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "cd2d3d7ad83c4cf0dd41a761c0eb200307d20697"
            }
        ]
    },
    {
        "repository_name": "cloth-backend",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "cbb5e59025123a25fee724ad1295da4abf323c40"
            }
        ]
    },
    {
        "repository_name": "Growly",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "37f5e145e954e28d77d7338443ec433d09426be6"
            }
        ]
    },
    {
        "repository_name": "kacpi-k",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "b45fd4e3d134f7363681b8e4ea0af158c891fe81"
            }
        ]
    },
    {
        "repository_name": "KCK_WannabeChess.com",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "4b416fc0dbdbc0e9c13a174ebbe442a91c5651f0"
            },
            {
                "name": "test_przed_dodaniem_do_maina",
                "last_commit_sha": "1325e5c44e7da10170204e04a9a4f81e923f00aa"
            }
        ]
    },
    {
        "repository_name": "omniscient-andrew-discord-bot",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "59a4a1db234dc22059b04c3135b5ca5577e0b98b"
            }
        ]
    },
    {
        "repository_name": "u_nas_dziala_hackathon_2024",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "course-page-v2",
                "last_commit_sha": "2ed97a9afa523616d587f0bd2960b75b9785747a"
            },
            {
                "name": "main",
                "last_commit_sha": "89138fb8f0bec0f0d577aef909b3fd5273a059f6"
            },
            {
                "name": "messenger",
                "last_commit_sha": "c8eb2dbe86a0bc9cc84c8d43a4d953e299fb39be"
            }
        ]
    },
    {
        "repository_name": "u_nas_dziala_project",
        "owner_login": "kacpi-k",
        "branches": [
            {
                "name": "main",
                "last_commit_sha": "f130dc9e7764a004065d7664cef1250a198bd561"
            }
        ]
    }
]
```
## Error Handling
If the requested GitHub user does not exit, the API returns:
```json
{
  "status": 404,
  "message": "GitHub user {username} not found"
}
```

## Running Tests
To execute the integration tests, run:
```sh
  ./mvnw test
```

## Author
**Kacper Koncki** [GitHub Profile](https://github.com/kacpi-k)