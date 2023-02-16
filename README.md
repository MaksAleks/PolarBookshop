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

## The application history

Some organization manages a specialized bookshop and wants to sell its books about the North Pole and the Arctic online.
A cloud native approach is being considered.

As a pilot project you are asked to build a Catalog Service, and for now it will only have one responsibility:
welcoming users to the book catalog.
This pilot project will be the foundation for actual products built as cloud native applications,
should it be successful and well-received.
