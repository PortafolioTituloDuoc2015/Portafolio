
package dto;

/**
 *
 * @author pamela.navarro
 */
public class RegionDto {
    private String region;

    public RegionDto(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "RegionDto{" + "region=" + region + '}';
    }
    
    
}
