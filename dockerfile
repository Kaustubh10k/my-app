# Use Python image
FROM python:3.9-slim

# Set working directory inside container
WORKDIR /app

# Copy files from repo to container
COPY . .

# Command to run when container starts
CMD ["python", "app.py"]