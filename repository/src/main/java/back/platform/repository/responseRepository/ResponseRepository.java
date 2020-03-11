package back.platform.repository.responseRepository;

import back.platform.model.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
