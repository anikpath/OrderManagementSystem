# Order Management API

This is a RESTful API built with Spring Boot for managing orders. It allows users to create, retrieve, update, and cancel orders. The application supports concurrency to handle simultaneous operations on orders effectively.

## Setup

1. **Clone the repository:**
   ```bash
   git clone (https://github.com/anikpath/OrderManagementSystem)
   API Endpoints
Create Order:
Method: POST
Endpoint: /orders
Request Body: JSON object representing the order
Response
{
  "items": ["item1", "item2"],
  "status": "pending"
}

Get Order by ID:
Method: GET
Endpoint: /orders/{id}
Path Parameter: id - ID of the order
GET /orders/1
Cancel Order:
Method: DELETE
Endpoint: /orders/{id}
Path Parameter: id - ID of the order
DELETE /orders/1
concurrency and lock and synchronization
The application uses synchronized methods and ConcurrentHashMap for handling concurrent access to orders.
Each order ID is associated with a lock to ensure thread safety during operations.
This approach prevents race conditions and maintains data consistency when multiple requests are processed simultaneously.














