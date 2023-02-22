# Polar Bookshop

It's a pet project made for learning cloud native application development techniques
by book [Cloud Native Spring in action](https://livebook.manning.com/book/cloud-native-spring-in-action)

### Useful links to resources I will be using during development
#### Building apps' images
- [Containerizing spring boot applications](https://spring.io/guides/topicals/spring-boot-docker/)
- [Multi-staged docker builds](https://docs.docker.com/build/building/multi-stage/)
- [Optimizing docker builds with cache](https://docs.docker.com/build/cache/)
- [Accelerate docker builds with COPY --link](https://www.howtogeek.com/devops/how-to-accelerate-docker-builds-and-optimize-caching-with-copy-link/)

#### Apps' designing and diagramming
- [C4 model for creating meaningful diagrams for designing an applications](https://www.infoq.com/articles/C4-architecture-model/)

### Disclamer

For local development I will use docker-compose to quickly test some functionality and minikbe.

For "production" environment (whatever it would mean in this case) I will use [Google Cloud Kubernetes (GKE)](https://cloud.google.com/kubernetes-engine)

### Configure GKE cluster

#### Set Up Google Cloud Account
Before you can set up a new Kubernetes cluster, you must set up your GKE environment. The process may change in the future, so I’ll only give you a few general instructions here. For complete instructions, refer to https://cloud.google.com/container-engine/docs/before-you-begin.

Roughly, the whole procedure includes:

- Signing up for a Google account if you don’t have one already.
- Creating a project in the Google Cloud Platform Console.
- Enabling billing. This does require your credit card info, but Google provides a 12-month free trial with a free $300 credit. And they don’t start charging automatically after the free trial is over.
- Downloading and installing the Google Cloud SDK, which includes the gcloud tool.
- Creating the cluster using the gcloud command-line tool.

#### Configure zone
I use the europe-west3 region based in Frankfurt, Germany.
It has three different zones - I’ll use the zone europe-west3-c.
The default zone for all gcloud operations can be set with the following command:

`gcloud config set compute/zone europe-west3-c`

#### Creating GKE cluster

`gcloud container clusters create polar-bookshop --num-nodes 3`

#### Configuring kubectl for GKE
To use kubectl with GKE cluster you will need a special plugin.
You can find the [instruction](https://cloud.google.com/kubernetes-engine/docs/how-to/cluster-access-for-kubectl)
in Google Cloud website

## The application history

Some organization manages a specialized bookshop and wants to sell its books about the North Pole and the Arctic online.
A cloud native approach is being considered.

As a pilot project you are asked to build a Catalog Service, and for now it will only have one responsibility:
welcoming users to the book catalog.
This pilot project will be the foundation for actual products built as cloud native applications,
should it be successful and well-received.
