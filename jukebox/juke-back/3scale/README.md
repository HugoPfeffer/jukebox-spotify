<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
<!-- [![LinkedIn][linkedin-shield]][linkedin-url] -->



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/HugoPfeffer/jukebox-spotify">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Jukefy + 3Scale</h3>

  <p align="center">
    Implementing Jukefy with 3Scale APIManager
    <br />
    <a href="https://github.com/HugoPfeffer/jukebox-spotify"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <!-- <a href="https://github.com/HugoPfeffer/jukebox-spotify">View Demo</a> -->
    ·
    <a href="https://github.com/HugoPfeffer/jukebox-spotify/issues">Report Bug</a>
    ·
    <a href="https://github.com/HugoPfeffer/jukebox-spotify/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<!-- [![Product Name Screen Shot][product-screenshot]](https://example.com) -->

This is a guide on how to deploy 3Scale on OpenShift and integrate the APICast with Jukefys Backend API. 

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

<!-- * [Next.js](https://nextjs.org/)
* [React.js](https://reactjs.org/)
* [Vue.js](https://vuejs.org/)
* [Angular](https://angular.io/)
* [Svelte](https://svelte.dev/)
* [Laravel](https://laravel.com)
* [Bootstrap](https://getbootstrap.com)
* [JQuery](https://jquery.com) -->
* [OpenShift](https://www.redhat.com/en/technologies/cloud-computing/openshift) 
* [Red Hat 3Scale](https://www.redhat.com/en/technologies/jboss-middleware/3scale) 
* [Quarkus](https://quarkus.io/) 

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

For this project you we will be deploying 3Scale on OpenShift with the built-in 3Scale Operator from OpenShift

For instructions on how to deploy 3Scale on OpenShift, please refer to [Vinicius Martinez](https://github.com/vinicius-martinez) guide.

* [OpenShift Setup](https://github.com/redhat-sa-brazil/3scale-workshop/blob/master/OPENSHIFT_SETUP.md)
* [3Scale Setup](https://github.com/redhat-sa-brazil/3scale-workshop/blob/master/3SCALE_SETUP.md)

### Prerequisites

* OpenShift 4.8 Cluster
* 3Scale 2.11

<p align="right">(<a href="#top">back to top</a>)</p>

## Integration with 3Scale
This module will cover how to integrate Jukefy backend API with 3Scale API Gateway. 

### Product

1. Create a product with the names and system-name
* Name: **Jukefy API**
* System Name: **jukefy-api**
* Description: **Managed API by 3scale**
<p align="right">(<a href="#top">back to top</a>)</p>

2. Add metrics to that product

`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Method`
`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Metrics`
===== image ======

3. Add Mapping Rules to that product
`Go to Jukefy product page -> Integration -> Mapping Rules -> Create Mapping rule`
===== image ======

    Add Mapping Rules for all metrics and methods we created.

===== image ======

4. Add an Application Plan for your managed API

`Go to Jukefy product page -> Applications -> Application Plan -> Create Application Plan`

    *Feel free to add custom billings to the API*

### Backend

1. Create a connection between the APICast and the Backend API from Jukefy.

`Top Left Dropdown -> Backends -> Create Backend`

2. Apply the same Methods and Metrics to the Backend the same way we did on Products

`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Method`
`Go to Jukefy product page -> Integration -> Methods & Metrics -> New Metrics`

3. Apply the same Mapping Rules to the Backend the same way we did on Products
`Go to Jukefy product page -> Integration -> Mapping Rules -> Create Mapping rule`
 
### Audiance

1. Add developer accounts and account plans so we can bill and analyse usage metrics. 

`Top Left Dropdown -> Audiance -> Create`

* Organizations/Group: Jukefy
* Username: your-name
* Email: your-email
* Password: your-password

2. Add an application to that Account
`Account Overview -> left menu -> Applications -> Listing -> Create Application`

    Select the Product, Application Plan and the Account we created

### Final Steps

1. Connect Backend API with the Product we created
`Top left dropdown -> Products -> Select Jukefy -> Integration -> Backends -> Add Backend`

2. Stage thoses changes and push it live for you to start consuming the API through 3scale. 

`Product Overview -> Configurations -> Promote Changes`


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Hugo Pfeffer - hugo.pguima@gmail.com

Gustavo Gianini - ggianini@gmail.com

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
<!-- ## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#top">back to top</a>)</p> -->


<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[contributors-url]: https://github.com/HugoPfeffer/jukebox-spotify/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[forks-url]: https://github.com/HugoPfeffer/jukebox-spotify/network/members
[stars-shield]: https://img.shields.io/github/stars/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[stars-url]: https://github.com/HugoPfeffer/jukebox-spotify/stargazers
[issues-shield]: https://img.shields.io/github/issues/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[issues-url]: https://github.com/HugoPfeffer/jukebox-spotify/issues
[license-shield]: https://img.shields.io/github/license/HugoPfeffer/jukebox-spotify.svg?style=for-the-badge
[license-url]: https://github.com/HugoPfeffer/jukebox-spotify/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
