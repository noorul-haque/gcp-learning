provider "google" {
  project     = "gcp-learning-428307"
  region      = "us-central1"
  zone        = "us-central1-a"
}

terraform {
  backend "gcs" {
    bucket = "tf-state-bucket-test123"
  }
}
