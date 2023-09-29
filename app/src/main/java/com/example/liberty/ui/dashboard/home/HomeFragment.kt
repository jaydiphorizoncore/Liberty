package com.example.liberty.ui.dashboard.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.R
import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.data.network.response.dashboardresponse.BannerData
import com.example.liberty.data.network.response.dashboardresponse.DashboardResponse
import com.example.liberty.databinding.FragmentHomeBinding
import com.example.liberty.ui.dashboard.home.category.categorydetailsactivity.CategoryActivity
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.CoursesActivity
import com.example.liberty.ui.dashboard.home.quiz.quizdetailsactivity.DailyQuizActivity
import com.example.liberty.ui.dashboard.home.packages.packagedetailsactivity.PackageActivity
import com.example.liberty.ui.dashboard.home.testimonials.testimonialdetailsactivity.TestimonialActivity
import com.example.liberty.ui.dashboard.home.toppers.toppersdetailsactivity.ToppersActivity
import com.example.liberty.ui.dashboard.home.viewmodel.ApiViewModel
import com.example.liberty.ui.dashboard.home.viewmodel.ViewModelFactory
import com.example.liberty.ui.dashboard.home.category.adapter.CategoryAdapter
import com.example.liberty.ui.dashboard.home.courses.adapter.CoursesAdapter
import com.example.liberty.ui.dashboard.home.quiz.adapter.DailyQuizAdapter
import com.example.liberty.ui.dashboard.home.packages.adapter.PackageAdapter
import com.example.liberty.ui.dashboard.home.testimonials.adapter.TestimonialAdapter
import com.example.liberty.ui.dashboard.home.toppers.adapter.ToppersAdapter
import com.example.liberty.ui.dashboard.home.packages.model.PackageData
import com.example.liberty.ui.dashboard.home.imageslider.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class HomeFragment : Fragment(), DashboardInterface {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var testimonialAdapter: TestimonialAdapter
    private lateinit var toppersAdapter: ToppersAdapter
    private lateinit var quizAdapter: DailyQuizAdapter
    private lateinit var coursesAdapter: CoursesAdapter

    companion object {
        var i = ""
    }

    private lateinit var viewModel: ApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        clickListener()

        val api = ApiInterface()
        val repository = ApiRepository(api)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[ApiViewModel::class.java]
        viewModel.dashboardInterface = this
        viewModel.getDashboard()

        preparePackageRecyclerView()
        return binding.root
    }


    private fun clickListener() {


        binding.tvPackage.setOnClickListener {
            val i = Intent(requireContext(), PackageActivity::class.java)
            requireContext().startActivity(i)
        }

        binding.tvCategory.setOnClickListener {
            val i = Intent(requireContext(), CategoryActivity::class.java)

            requireContext().startActivity(i)
        }
        binding.tvTestimonial.setOnClickListener {
            val i = Intent(requireContext(), TestimonialActivity::class.java)
            requireContext().startActivity(i)
        }
        binding.tvToppers.setOnClickListener {
            val i = Intent(requireContext(), ToppersActivity::class.java)
            requireContext().startActivity(i)
        }
        binding.tvDailyQuiz.setOnClickListener {
            val i = Intent(requireContext(), DailyQuizActivity::class.java)
            requireContext().startActivity(i)
        }
    }

    private fun preparePackageRecyclerView() {
        val itemList = ArrayList<PackageData>()
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )
        itemList.add(
            PackageData(
                "Top Selling",
                "GCERT (General science)- Akhram Sherasiya",
                "120 Subjects",
                "200 Videos",
                "120 Materials",
                "200 Tests",
                "Only ₹ 2000/-"
            )
        )

        val packageRecyclerAdapter = PackageAdapter(itemList)
        binding.recyclerPackages.adapter = packageRecyclerAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tabLl.addTab(binding.tabLl.newTab())
        binding.tabLl.addTab(binding.tabLl.newTab())
        binding.tabLl.addTab(binding.tabLl.newTab())

        binding.viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tabLl))
        binding.tabLl.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    override fun onStarted() {
        Log.d("TAG", "onStartedDashBoard")
        binding.homeProgress.visibility = View.VISIBLE
    }

    override fun onSuccess(dashboardResponse: DashboardResponse?) {
        binding.homeProgress.visibility = View.GONE
        binding.btnAllCourse.isSelected = true
        if (dashboardResponse != null) {
            viewPagerAdapter =
                ViewPagerAdapter(requireContext(), imageList = dashboardResponse.data.bannerData)
            binding.viewPager.adapter =
                viewPagerAdapter //  categoryAdapter.setData(dashboardResponse.data.categories)

            categoryAdapter = CategoryAdapter(requireContext(), dashboardResponse.data.categories)
            binding.recyclerCategory.adapter = categoryAdapter

            testimonialAdapter = TestimonialAdapter(
                requireContext(),
                dashboardResponse.data.testimonials.testimonialsData
            )
            binding.recyclerTestimonial.adapter = testimonialAdapter

            toppersAdapter =
                ToppersAdapter(requireContext(), dashboardResponse.data.toppers.topersData)
            binding.recyclerTopper.adapter = toppersAdapter
            quizAdapter = DailyQuizAdapter(requireContext(), dashboardResponse.data.tests)
            binding.recyclerDailyQuiz.adapter = quizAdapter

            coursesAdapter =
                CoursesAdapter(requireContext(), dashboardResponse.data.courses.allCourses.courses)
            binding.recyclerCourses.adapter = coursesAdapter
            binding.tvDataNotFound.visibility = View.GONE

            binding.btnAllCourse.setOnClickListener {
                i = ""
                binding.btnAllCourse.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = true
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = false

                if (dashboardResponse.data.courses.allCourses.courses.isNullOrEmpty()) {
                    binding.recyclerCourses.visibility = View.GONE
                    binding.tvDataNotFound.visibility = View.VISIBLE
                } else {
                    binding.recyclerCourses.visibility = View.VISIBLE
                    binding.tvDataNotFound.visibility = View.GONE
                    coursesAdapter = CoursesAdapter(
                        requireContext(),
                        dashboardResponse.data.courses.allCourses.courses
                    )
                }
                binding.recyclerCourses.adapter = coursesAdapter
            }
            binding.btnPopular.setOnClickListener {
                i = "1"
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = true
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = false

                if (dashboardResponse.data.courses.popularCourses.courses.isNullOrEmpty()) {
                    binding.recyclerCourses.visibility = View.GONE
                    binding.tvDataNotFound.visibility = View.VISIBLE
                } else {
                    binding.recyclerCourses.visibility = View.VISIBLE
                    binding.tvDataNotFound.visibility = View.GONE
                    coursesAdapter = CoursesAdapter(
                        requireContext(),
                        dashboardResponse.data.courses.popularCourses.courses
                    )
                }
                binding.recyclerCourses.adapter = coursesAdapter
            }
            binding.btnAdvance.setOnClickListener {
                i = "2"
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = true
                binding.btnNewest.isSelected = false

                if (dashboardResponse.data.courses.advanceCourses.courses.isNullOrEmpty()) {
                    binding.recyclerCourses.visibility = View.GONE
                    binding.tvDataNotFound.visibility = View.VISIBLE
                } else {
                    binding.recyclerCourses.visibility = View.VISIBLE
                    binding.tvDataNotFound.visibility = View.GONE
                    coursesAdapter = CoursesAdapter(
                        requireContext(),
                        dashboardResponse.data.courses.advanceCourses.courses
                    )
                }
                binding.recyclerCourses.adapter = coursesAdapter
            }
            binding.btnNewest.setOnClickListener {
                i = "3"
                binding.btnPopular.setBackgroundResource(R.drawable.button_style)
                binding.btnAllCourse.isSelected = false
                binding.btnPopular.isSelected = false
                binding.btnAdvance.isSelected = false
                binding.btnNewest.isSelected = true
                if (dashboardResponse.data.courses.newestCourses.courses.isNullOrEmpty()) {
                    binding.recyclerCourses.visibility = View.GONE
                    binding.tvDataNotFound.visibility = View.VISIBLE
                } else {
                    binding.recyclerCourses.visibility = View.VISIBLE
                    binding.tvDataNotFound.visibility = View.GONE
                    coursesAdapter = CoursesAdapter(
                        requireContext(),
                        dashboardResponse.data.courses.newestCourses.courses
                    )
                }
            }
        }
        binding.tvCourses.setOnClickListener {
            val i = Intent(requireContext(), CoursesActivity::class.java)
            requireContext().startActivity(i)
        }
    }

    override fun onFailure(message: String) {
        binding.homeProgress.visibility = View.GONE
        Log.d("TAG", "onFailure")
    }
}