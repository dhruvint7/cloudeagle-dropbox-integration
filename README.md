# 📦 CloudEagle - Dropbox Integration (Spring Boot + Feign Client)

I built this project as part of the **CloudEagle assignment** to demonstrate a clean and secure integration with the **Dropbox Business API** using **Spring Boot** and **OpenFeign**.

The focus is on writing maintainable code, proper request/response modeling, and following secure best practices for external API calls.

---

## 🚀 Features

✅ Dropbox Business API integration using Feign  
✅ Clean, layered Spring Boot architecture  
✅ Custom Feign configuration with header interceptor  
✅ Centralized exception handling via Controller Advice(`GlobalExceptionHandler`)  
✅ Request/Response DTO mapping for type-safe data handling  
✅ Secure token handling through environment variables  
✅ Gradle build setup and JUnit test coverage for controller & service


---

## 🧩 Project Structure

```
com.assignment.dropbox
├── client          # Feign client for Dropbox API endpoints
├── config          # Feign configuration, interceptors, error decoder
├── controller      # REST controllers exposing endpoints
├── exception       # Custom exceptions and global error handler
├── model           # DTOs for API request/response mapping
├── service         # Service layer with business logic
└── DropboxApplication.java
```

---

## ⚙️ Tech Stack

| Layer | Technology |
|--------|-------------|
| Framework | Spring Boot 3.x |
| HTTP Client | Spring Cloud OpenFeign |
| Build Tool | Gradle |
| JSON Mapper | Jackson |
| Logging | SLF4J + Logback |
| Testing | JUnit 5 + Mockito |
| Environment Management | `.env` (for local) / Azure Key Vault / Wrangler Secrets (for prod) |

---

## 🛠️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/dhruvint7/cloudeagle-dropbox-integration.git
cd cloudeagle-dropbox-integration
```

---

### 2️⃣ Set Environment Variable for Access Token

#### Local Setup (`.env` file)
Create a `.env` file in the project root and add:
```
DROPBOX_ACCESS_TOKEN=sl.u.your_actual_long_dropbox_access_token
```

Then ensure `.env` is ignored by Git:
```
.env
```

Your `application.yml` should look like:
```yaml
dropbox:
  base-url: https://api.dropboxapi.com/2
  access-token: ${DROPBOX_ACCESS_TOKEN}
```

#### Production Setup
Use secret management systems like:
- **Azure Key Vault**
- **Wrangler Secrets**


---

## ▶️ Running the Application

### Using Gradle
```bash
./gradlew bootRun
```

Or build and run the jar:
```bash
./gradlew clean build
java -jar build/libs/dropbox-integration.jar
```

Once running, the API will be available at:
```
http://localhost:8081
```

---

## 📡 API Endpoints

| Endpoint | Method | Description |
|-----------|---------|-------------|
| `/dropbox/team-name` | POST | Returns the team’s display name |
| `/dropbox/team` | POST | Fetches complete team details |
| `/dropbox/list-members` | POST | Lists all members in the team |
| `/dropbox/events` | POST | Retrieves audit log events |

---

## 💬 Example Requests

**List Members**
```json
{
  "limit": 5,
  "includeRemoved": false
}
```

**Team Events**
```json
{
  "limit": 10,
  "category": "logins"
}
```

---

## ✅ Example Response

```json
{
  "members": [
    {
      "profile": {
        "email": "john.doe@company.com",
        "displayName": "John Doe"
      }
    }
  ],
  "hasMore": false
}
```

---

## 🧪 Running Tests

To run all tests:
```bash
./gradlew test
```

Tests included:
- `DropboxControllerTest`
- `DropboxServiceTest`

---

## 💥 Error Handling

All Dropbox API errors are intercepted and wrapped as `DropboxApiException`,  
which are handled globally by `GlobalExceptionHandler`.

Example error response:
```json
{
  "status": 400,
  "message": "Invalid filters. Do not specify both event_type and category."
}
```

---

## 🔒 Security Practices

✅ Access token stored in environment variables only  
🚫 No secrets or credentials committed to Git  
☁️ Recommended: Azure Key Vault or Wrangler Secrets for production  
📜 Sensitive data masked in logs  

---

## 🧠 Highlights

- Strong focus on **code readability and structure**  
- Proper **error propagation** using Feign’s `ErrorDecoder`  
- Secure, configurable **auth handling** via environment variables  
- Production-ready **integration flow** with Dropbox APIs  

---

## 🧑‍💻 Author   

**Dhruvin Thakkar**  
Backend Developer • Focused on scalable, secure, and maintainable systems.  

🔗 [LinkedIn](https://www.linkedin.com/in/dhruvin-thakkar-564b58216)

---

> 💡 *Built with precision, best practices, and a clean architecture mindset for CloudEagle’s backend assignment.*
