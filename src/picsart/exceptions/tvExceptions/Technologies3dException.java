package picsart.exceptions.tvExceptions;

public class Technologies3dException extends RuntimeException {
    public Technologies3dException() {
        super("3D technologies must be or 'active 3d' or 'passive 3d' or 'not 3d': ");
    }
}
