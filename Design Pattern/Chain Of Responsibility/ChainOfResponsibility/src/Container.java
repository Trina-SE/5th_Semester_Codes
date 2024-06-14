import java.util.ArrayList;
import java.util.List;

class Container extends Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component child) {
        children.add(child);
        child.setContainer(this);
    }
}