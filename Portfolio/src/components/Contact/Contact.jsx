
import styles from './Contact.module.css'
import getImageUrl from "../../utils";

const Contact = () => {
  return (
    <footer id="contact" className={styles.container}>
      <div className={styles.text}>
        <h2>Contact</h2>
        <p>Feel free to reach out</p>
      </div>
      <ul className={styles.links}>
        <li className={styles.link}>
          <img src={getImageUrl("contact/emailIcon.png")} alt="Email Icon" />
          <a href="mailto:tsionshimelis900@gmail.com"></a>
        </li>
        <li className={styles.link}>
          <img
            src={getImageUrl("contact/linkedinIcon.png")}
            alt="Linkedin Icon"
          />
          <a href="https://www.linkedin.com/myname">linkedin.com/tsion</a>
        </li>
        <li className={styles.link}>
          <img
            src={getImageUrl("contact/githubinIcon.png")}
            alt="Github Icon"
          />
          <a href="https://www.github.com/myname">github.com/TsiOnshime</a>
        </li>
      </ul>
    </footer>
  );
};

export default Contact;
