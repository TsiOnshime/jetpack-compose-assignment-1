// import React from 'react'
import styles from "./Hero.module.css"

import { getImageUrl } from "../../utils"

const Hero = () => {
  return (
    <section className={styles.container}>
      <div className={styles.content}>
        <h1 className={styles.title}>Hi, I&apos;m Tsion</h1>
        <p className={styles.description}>
          I&apos;m a Software Engineering Student and a full stack developer
          with NodeJS and React experience. Reach out if you would like to learn
          more{" "}
        </p>
        <a href="mailto:tsionshimelis900@gmail.com" className={styles.contactBtn}>Contact Me</a>
      </div>
      <img src={getImageUrl("hero/heroImage.png")} alt="Hero Image of me" className={styles.heroImg}/>
      <div className={styles.topBlur}></div>
      <div className={styles.bottomBlur}></div>
    </section>
  ); }

export default Hero
