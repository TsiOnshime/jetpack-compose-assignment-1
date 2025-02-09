import { getImageUrl } from "../../utils";
import styles from "./About.module.css";

const About = () => {
  return (
    <section className={styles.container} id="about">
      <h2 className={styles.title}>About</h2>
      <div className={styles.smallerContainer}>
        <img
          src={getImageUrl("about/aboutImage.png")}
          alt="me sitting with a laptop"
          className={styles.aboutMeImg}
        />
        <ul className={styles.capabilities}>
          <li>
            <img src={getImageUrl("about/cursorIcon.png")} alt="cursor icon" />
            <div>
              <h3>Frontend Developer</h3>
              <p>
                I&apos;m a front-end developer with experience in building
                responsive and optimized sites
              </p>
            </div>
          </li>
          <li>
            <img src={getImageUrl("about/serverIcon.png")} alt="server Icon" />
            <div>
              <h3>Backend Developer</h3>
              <p>
                I have experience developing fast and optimised back-end systems
                and APIs
              </p>
            </div>
          </li>
          <li>
            <img src={getImageUrl("about/uiIcon.png")} alt="UI Icon" />
            <div>
              <h3>UI Designer</h3>
              <p>
                I have designed multiple landing pages and have created design
                systems as well
              </p>
            </div>
          </li>
        </ul>
      </div>
    </section>
  );
};

export default About;
