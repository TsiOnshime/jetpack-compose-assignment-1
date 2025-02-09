import getImageUrl from "../../utils";
import styles from "./ProjectCard.module.css"

const ProjectCard = ({
  project: { title, imageSrc, description, skills, demo, source },
}) => {
  return (
    <div className={styles.container}>
      <img
        src={getImageUrl(imageSrc)}
        alt={`image of ${title}`}
        className={styles.image}
      ></img>
      <h3 className={styles.title}>{title}</h3>
      <p className={styles.description}>{description}</p>
      <ul className={styles.skills}>
        {skills.map((skill, id) => {
          return (
            <li key={id} className={styles.skill}>
              {skill}
            </li>
          );
        })}
      </ul>
      <div className={styles.links}>
        <a href={demo} className={styles.link}>
          demo
        </a>
        <a href={source} className={styles.link}>
          source
        </a>
      </div>
    </div>
  );
};

export default ProjectCard;
