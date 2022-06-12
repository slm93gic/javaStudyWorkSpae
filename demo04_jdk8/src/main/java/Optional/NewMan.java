package Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class NewMan {

    private Optional<Godness> godness = Optional.empty();

    private Godness god;

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }
}
