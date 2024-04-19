package org.gb.demothymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BvnNumsController {
    private List<Integer> nums = List.of(10, 5, 3, 12, 6, 7, 5, 3);

    @GetMapping("/bvn")
    public String getListPage() {
        return "/admin/index";
    }

    //        <td><a th:href="@{/list/even}">Tìm các giá trị chẵn trong list</a></td>
    @GetMapping("/bvn/c1")
    public String c1(Model model) {
        List<Integer> evenNums = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        model.addAttribute("result", evenNums);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c2")
    public String c2(Model model) {
        List<Integer> numsGreaterThanFive = nums.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        model.addAttribute("result", numsGreaterThanFive);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c3")
    public String c3(Model model) {
        int maxNum = nums.stream()
                .max(Integer::compareTo)
                .get();
        model.addAttribute("result", maxNum);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c4")
    public String c4(Model model) {
        int minNum = nums.stream()
                .min(Integer::compareTo)
                .get();
        model.addAttribute("result", minNum);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c5")
    public String c5(Model model) {
        int sum = nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
        model.addAttribute("result", sum);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c6")
    public String c6(Model model) {
        List<Integer> notDuplicateNums = nums.stream()
                .distinct()
                .collect(Collectors.toList());
        model.addAttribute("result", notDuplicateNums);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c7")
    public String c7(Model model) {
        List<Integer> fiveNums = nums.stream()
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("result", fiveNums);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c8")
    public String c8(Model model) {
        List<Integer> threeToFiveNums = nums.stream()
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("result", threeToFiveNums);
        return "/admin/ans/c2";
    }

    @GetMapping("/bvn/c9")
    public String c9(Model model) {
        int five = nums.stream()
                .filter(n -> n > 5)
                .findFirst()
                .orElse(-1);
        model.addAttribute("result", five);
        return "/admin/ans/c2";
    }
    }
